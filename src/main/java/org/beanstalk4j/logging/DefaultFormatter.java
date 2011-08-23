package org.beanstalk4j.logging;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class DefaultFormatter extends Formatter {

	@Override
	public String format(LogRecord record) {
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		sb.append(fmt.format(new Date(record.getMillis())));
		sb.append(formatMessage(record));
		sb.append("\n");
		return sb.toString();
	}

}
