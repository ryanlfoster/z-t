package com.australia.atdw.repository;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.FileCopyUtils;

/**
 * Implementation of {@link HttpMessageConverter} that can read and write
 * strings.
 * 
 * <p>
 * By default, this converter supports all media types (
 * <code>&#42;&#47;&#42;</code>), and writes with a {@code Content-Type} of
 * {@code text/plain}. This can be overridden by setting the
 * {@link #setSupportedMediaTypes(java.util.List) supportedMediaTypes} property.
 * 
 * @author Arjen Poutsma
 * @since 3.0
 */
public class AtdwInputStreamMessageConverter extends AbstractHttpMessageConverter<InputStream> {

	public static final Charset DEFAULT_CHARSET = Charset.forName("ISO-8859-1");

	private final List<Charset> availableCharsets;

	private boolean writeAcceptCharset = true;

	public AtdwInputStreamMessageConverter() {
		super(new MediaType("text", "plain", DEFAULT_CHARSET), MediaType.ALL);
		this.availableCharsets = new ArrayList<Charset>(Charset.availableCharsets().values());
	}

	/**
	 * Indicates whether the {@code Accept-Charset} should be written to any
	 * outgoing request.
	 * <p>
	 * Default is {@code true}.
	 */
	public void setWriteAcceptCharset(boolean writeAcceptCharset) {
		this.writeAcceptCharset = writeAcceptCharset;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz != null && (InputStream.class.equals(clazz));
	}

	@Override
	protected InputStream readInternal(@SuppressWarnings("rawtypes") Class clazz, HttpInputMessage inputMessage)
		throws IOException {
		return IOUtils.toBufferedInputStream(inputMessage.getBody());
	}

	@Override
	protected Long getContentLength(InputStream s, MediaType contentType) {
		if (contentType != null && contentType.getCharSet() != null) {
			Charset charset = contentType.getCharSet();
			try {
				return (long) IOUtils.toString(s, charset.name()).getBytes(charset.name()).length;
			} catch (UnsupportedEncodingException ex) {
				// should not occur
				throw new InternalError(ex.getMessage());
			} catch (IOException ex) {
				throw new InternalError(ex.getMessage());
			}
		} else {
			return null;
		}
	}

	@Override
	protected void writeInternal(InputStream s, HttpOutputMessage outputMessage) throws IOException {
		if (writeAcceptCharset) {
			outputMessage.getHeaders().setAcceptCharset(getAcceptedCharsets());
		}
		MediaType contentType = outputMessage.getHeaders().getContentType();
		Charset charset = contentType.getCharSet() != null ? contentType.getCharSet() : DEFAULT_CHARSET;
		FileCopyUtils.copy(new InputStreamReader(s), new OutputStreamWriter(outputMessage.getBody(), charset));
	}

	/**
	 * Return the list of supported {@link Charset}.
	 * 
	 * <p>
	 * By default, returns {@link Charset#availableCharsets()}. Can be
	 * overridden in subclasses.
	 * 
	 * @return the list of accepted charsets
	 */
	protected List<Charset> getAcceptedCharsets() {
		return this.availableCharsets;
	}

}
