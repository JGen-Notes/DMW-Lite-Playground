package eu.jgen.notes.dmw.lite.tests.templates;

import java.sql.Time;

import eu.jgen.notes.dmw.lite.runtimes.XInt;
import eu.jgen.notes.dmw.lite.runtimes.XShort;
import eu.jgen.notes.dmw.lite.runtimes.XString;
import eu.jgen.notes.dmw.lite.runtimes.XStructure;
import eu.jgen.notes.dmw.lite.runtimes.XTime;
import eu.jgen.notes.dmw.lite.runtimes.XWidget;

public class LogWidget  extends XWidget {
	
	public static LogWidget getInstance() {
		return new LogWidget();
	}
	
	public LogWidget() {		
	}

	public  class Log extends XStructure {
		
		public Log() {		
		}
		
		public XShort entryType; 
	   	public XString message;
	   	public XTime timeCreated;
	   	public XInt counter;
	   	
	   	public void init() {
	   		entryType = new XShort();
	   		entryType.value = 0;
	   		message = new XString();
	   		message.value = "";
	   		timeCreated = new XTime();
	   		timeCreated.value  = new Time(0);
	   		counter = new XInt();
	   		counter.value = 0;
	   	}
	   	
	   	public void reset() {
	   		entryType = new XShort();
	   		entryType.value = 0;
	   		message = new XString();
	   		message.value = "";
	   		timeCreated = new XTime();
	   		timeCreated.value  = new Time(0);
	   		counter = new XInt();
	   		counter.value = 0;
	   	}

	}
	
	public Log impLog;
	
	public Log expLog;
	
	public void start() {
		expLog.counter.value = impLog.counter.value + 1000;
	}

}
