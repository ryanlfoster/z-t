import javax.jcr.query.*
import javax.jcr.*
import org.apache.sling.api.resource.*
import com.australia.utils.PathUtils;
import org.apache.commons.lang.StringUtils;
import com.day.cq.commons.jcr.JcrUtil;

TagManager tagManager = resourceResolver.adaptTo(TagManager.class)

def contentPath = "/content/usergenerated/food-and-wine"
def articleContentPath = "/content/food-and-wine/experiences"
def tagsPath = "/etc/tags/ta/food-and-wine/category"
def tagsPathPlace = "/etc/tags/ta/place"

def tags = getCategoryTags(tagsPath)
tags.each { t -> println "$t.title" }

def query = createSQL2Query(contentPath)
def result = query.execute()
def rows = result.rows

rows.each { row ->
    Resource res = resourceResolver.getResource(row.path)
    Page experience = res.adaptTo(Page.class)
    if(experience!=null && experience.businessName!=null){
        def articleName = JcrUtil.createValidName(experience.businessName, JcrUtil.HYPHEN_LABEL_CHAR_MAPPING, "_")
        def articleInitial = Character.toString(articleName.charAt(0)).toLowerCase();
        def articlePath = articleContentPath + "/" + articleInitial + "/" + articleName
        def articleRes = resourceResolver.getResource(articlePath)
        def articlePage= articleRes.adaptTo(Page.class)
        if(articlePage!=null){
            Tag[] newTags = tags.findAll{ "category-$it.title".toLowerCase() == experience.primaryCategory || "category-$it.title".toLowerCase() == experience.secondaryCategory } as Tag[]
            println "$articlePath, $experience.primaryCategory, $experience.secondaryCategory, $experience.selectTerritory"
           
            def stringArray = newTags.collect { it.path }
            stringArray << "$tagsPathPlace/" + JcrUtil.createValidName(experience.selectTerritory, JcrUtil.HYPHEN_LABEL_CHAR_MAPPING, "_")
            articlePage."cq:tags" = stringArray.toArray()
           
            def categoryRes = articlePage.getContentResource().getChild("category")
            Node categoryNode
            if(categoryRes == null){
                categoryNode = articlePage.getContentResource().adaptTo(Node.class).addNode("category", "nt:unstructured")
                categoryNode.setProperty("sling:resourceType", "foodandwine/components/content/category")
                categoryNode.setProperty("cq:lastModified", Calendar.getInstance());       
                categoryNode.setProperty("cq:lastModifiedBy", session.getUserID());
            } else {
                categoryNode = categoryRes.adaptTo(Node.class)
            }
           
            def c = 1
            newTags.each{ nt ->
                def imagePath = "/content/dam/food-and-wine/icons/categories/category-icon-" + nt.title.toLowerCase() + "-white.png"
                categoryNode.setProperty("caption$c", nt.title)
                categoryNode.setProperty("imagePath$c", imagePath)
                c++
            }
            resourceResolver.commit()
        }
    }
}


def getCategoryTags(tagsPath){
    def queryTags = createSQL2Query(tagsPath)
    def resultTags = queryTags.execute()
    def rowsTags = resultTags.rows
    def tagList = []
   
    rowsTags.each { row ->
        Tag tag = resourceResolver.getResource(row.path).adaptTo(Tag.class)
        if(tag!=null){
            tagList.add(tag)
        }
    }
    return tagList
}

def createSQL2Query(startPage) {
    def queryManager = session.workspace.queryManager
    def statement = "select * from [nt:base] as p where (isdescendantnode (p, '$startPage'))"
    def query = queryManager.createQuery(statement, Query.JCR_SQL2)
    query
}