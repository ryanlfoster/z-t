package com.australia.content.tag;

import com.australia.content.domain.ContentSearchParameters;
import com.australia.content.domain.ContentSearchResult;
import com.australia.content.service.ContentSearchException;
import com.australia.content.service.ContentSearchService;
import com.australia.utils.MosaicUtils;
import com.australia.utils.PathUtils;
import com.australia.www.components.page.search.DisplayMode;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.scripting.SlingScriptHelper;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Arrays;

public class ContentSearchTag extends SimpleTagSupport {

	private String term;
	private String tagid;
	private Integer page;
	private Integer limit;
	private String mode;
	private String var;

	@Override public void doTag() throws JspException, IOException {

		final PageContext pageContext = (PageContext) getJspContext();
		final SlingScriptHelper sling = (SlingScriptHelper) pageContext.getAttribute("sling");
		final ContentSearchService service = sling.getService(ContentSearchService.class);
		final SlingHttpServletRequest request = (SlingHttpServletRequest) pageContext.getRequest();
		Resource pathResource = request.getResource();

		ContentSearchParameters params = new ContentSearchParameters();
		params.setLanguagePath(PathUtils.getLanguageResource(pathResource).getPath());
		params.setCount(limit == null ? 10 : limit);
		params.setPage(page == null ? 1 : page);
		params.setText(term == null || term.trim().isEmpty() ? null : term);
		if (tagid != null && !tagid.trim().isEmpty()) {
			params.setTags(Arrays.asList(tagid));
		}

		try {

			ContentSearchResult result = service.search(params);
			if(mode == null || DisplayMode.fromName(mode) == DisplayMode.GRID) {
				pageContext.setAttribute(var, MosaicUtils.convertToMosaic(result.getContent()),
					PageContext.REQUEST_SCOPE);
			} else {
				pageContext.setAttribute(var, result.getContent(), PageContext.REQUEST_SCOPE);
			}

		} catch (ContentSearchException e) {
			throw new JspException(e);
		}
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getTagid() {
		return tagid;
	}

	public void setTagid(String tagId) {
		this.tagid = tagId;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}
}
