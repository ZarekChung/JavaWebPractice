package com.web.tag;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;



public class SimpleTagTest extends SimpleTagSupport{

	private List songList;
	public void setSongList(List songList) {
		this.songList = songList;
	}
	@Override
	    public void doTag() throws JspException, IOException {
	    Iterator i = songList.iterator();   
	    
	    while(i.hasNext())
	    {
	    	Song song = (Song) i.next();
	    	getJspContext().setAttribute("song", song);
	    	getJspBody().invoke(null);
	    }
		//getJspContext().getOut().print("This is first simple tag");
	    }
	
	
	
	
}
