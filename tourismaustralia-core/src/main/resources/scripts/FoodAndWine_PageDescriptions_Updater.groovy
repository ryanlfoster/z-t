def QUERY_STRING = "SELECT * FROM [cq:PageContent] AS s WHERE [cq:template] like '%/apps/foodandwine/templates/articlepage%'"
def queryManager = session.getWorkspace().getQueryManager()
def query = queryManager.createQuery(QUERY_STRING, "JCR-SQL2")
def result = query.execute().nodes.each(){node ->
    def jcrdesc = node.get("jcr:description")
    if (!node.articleDescription && jcrdesc?.trim()) {
        node.articleDescription = jcrdesc
        session.save()
        println node.path
    }
}
println "Page description migration script completed."