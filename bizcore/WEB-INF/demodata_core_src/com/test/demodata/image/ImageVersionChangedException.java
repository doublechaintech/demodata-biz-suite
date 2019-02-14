
package com.test.demodata.image;
import com.test.demodata.EntityNotFoundException;

public class ImageVersionChangedException extends ImageManagerException {
	private static final long serialVersionUID = 1L;
	public ImageVersionChangedException(String string) {
		super(string);
	}


}


