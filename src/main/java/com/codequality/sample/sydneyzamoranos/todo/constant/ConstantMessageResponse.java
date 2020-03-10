package com.codequality.sample.sydneyzamoranos.todo.constant;

final public class ConstantMessageResponse {
  private final static String SUCCESS = "Success ";
  private final static String ERROR = "Error ";
  
  private final static String TODO_TASK = "todo task";
  
  private final static String CREATING = "creating";
  private final static String UPDATING = "updating";
  private final static String DELETING = "deleting";
  private final static String RETRIEVING = "retrieving";
  
  public final static String CREATION_SUCCESS = SUCCESS + CREATING + TODO_TASK;
  public final static String CREATION_FAILED =  ERROR + CREATING + TODO_TASK;
  
  public final static String UPDATING_SUCCESS = SUCCESS + UPDATING + TODO_TASK;
  public final static String UPDATING_FAILED = ERROR + UPDATING + TODO_TASK;
  
  public final static String DELETING_SUCCESS = SUCCESS + DELETING + TODO_TASK;
  public final static String DELETING_FAILED = ERROR + DELETING + TODO_TASK;
  
  public final static String RETRIEVING_SUCCESS = SUCCESS + RETRIEVING + TODO_TASK;
  public final static String RETRIEVING_FAILED = ERROR + RETRIEVING + TODO_TASK;
  
  
}
