package com.australia.www.components.content.links;

import com.australia.foodandwine.link.TextLink;
import com.australia.widgets.multicomposite.MultiCompositeField;
import com.citytechinc.cq.component.annotations.Component;
import com.citytechinc.cq.component.annotations.DialogField;
import com.citytechinc.cq.component.annotations.FieldProperty;
import com.citytechinc.cq.component.annotations.Tab;
import java.util.List;
import org.apache.sling.api.SlingHttpServletRequest;

/**
 * Created by wma on 12/03/14.
 */
@Component(value = "Links", group = ".hidden",
        tabs = {@Tab(title = "Links")})
public class Links {
    
    @DialogField(fieldLabel = "Links", fieldDescription = "List of Links", additionalProperties = @FieldProperty(name = "width", value = "400"))
	@MultiCompositeField
	private List<TextLink> linksList;

    public Links(SlingHttpServletRequest request) {
        
    }


}
