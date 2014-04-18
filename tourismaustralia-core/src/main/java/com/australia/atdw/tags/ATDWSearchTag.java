package com.australia.atdw.tags;

import com.australia.atdw.domain.ATDWCategory;
import com.australia.atdw.domain.ATDWProduct;
import com.australia.atdw.domain.ATDWProductSearchParameters;
import com.australia.atdw.domain.ATDWProductSearchParametersBuilder;
import com.australia.atdw.service.ATDWProductService;
import com.google.common.base.Joiner;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.scripting.SlingScriptHelper;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public final class ATDWSearchTag extends SimpleTagSupport {

	private static final int DEFAULT_COUNT = 12;

	private String var;
	private String term;
	private String category;
	private String state;
	private String region;
	private String city;
	private Integer page;
	private Integer count;

	@Override
	public void doTag() throws JspException, IOException {

		// Parameter validation
		final List<String> errors = new ArrayList<String>();
		if (var == null) {
			errors.add("'var' is required");
		}
		final ATDWCategory cat = ATDWCategory.get(category);
		if (category == null) {
			errors.add("'category' is required");
		}
		if (cat == null) {
			errors.add("provided category not recognized");
		}
		if (!errors.isEmpty()) {
			String error = Joiner.on(", ").join(errors);
			throw new JspException(error);
		}

		final PageContext pageContext = (PageContext) getJspContext();
		final SlingScriptHelper sling = (SlingScriptHelper) pageContext.getAttribute("sling");
		final ATDWProductService productService = sling.getService(ATDWProductService.class);
		final SlingHttpServletRequest request = (SlingHttpServletRequest) pageContext.getRequest();
		final Locale locale = request.getLocale();
		final ResourceBundle bundle = request.getResourceBundle(locale);

		// Build parameters
		final ATDWProductSearchParametersBuilder builder = new ATDWProductSearchParametersBuilder();
		final ATDWProductSearchParameters params = builder.setText(term)
			.setCategory(cat)
			.setState(region)
			.setCity(city)
			.setPage(page == null ? 1 : page)
			.setCount(count == null ? DEFAULT_COUNT : count)
			.build();

		// Perform search
		final List<ATDWProduct> results = productService.search(params);

		// output results to page context
		pageContext.setAttribute(var, results);
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
		if (this.term != null && this.term.trim().isEmpty()) {
			this.term = null;
		}
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
		if (this.state != null && this.state.trim().isEmpty()) {
			this.state = null;
		}
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
		if (this.region != null && this.region.trim().isEmpty()) {
			this.region = null;
		}
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
		if (this.city != null && this.city.trim().isEmpty()) {
			this.city = null;
		}
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
