package org.hahadeng.dp.mydecorate.annotion;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TimestampRequestBody {
}
