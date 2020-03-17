package com.test.demodata;

import com.skynet.infrastructure.graphservice.BaseQuery;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class DemodataQuery extends BaseQuery {
	
	public DemodataQuery(Class startType, String ... pStart) {
        super(startType, pStart);
        super.setProject("demodata");
  }

  public DemodataQuery(Object start){
    this(start.getClass(), getId(start));
  }

  private static String getId(Object pStart) {
      BeanWrapper bw = new BeanWrapperImpl(pStart);
      return String.valueOf(bw.getPropertyValue("id"));
  }
}














