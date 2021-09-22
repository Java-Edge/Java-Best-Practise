package com.javaedge.logging.duplicate;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author JavaEdge
 */
public class MulLevelsFilter extends Filter<ILoggingEvent> {

    @Getter
    @Setter
    private String levels;
    private List<Integer> levelList;

    @Override
    public FilterReply decide(ILoggingEvent event) {

        if (levelList == null && !StringUtils.isEmpty(levels)) {
            levelList = Arrays.stream(levels.split("\\|"))
                    .map(Level::valueOf)
                    .map(Level::toInt)
                    .collect(Collectors.toList());
        }

        assert levelList != null;
        if (levelList.contains(event.getLevel().toInt())) {
            return FilterReply.ACCEPT;
        } else {
            return FilterReply.DENY;
        }
    }

}