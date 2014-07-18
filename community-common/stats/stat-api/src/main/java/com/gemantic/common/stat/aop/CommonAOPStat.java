/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gemantic.common.stat.aop;

import com.gemantic.common.stat.CommonStat;
import org.aspectj.lang.ProceedingJoinPoint;
/**
 *
 * @author hongzhong
 */
public abstract class CommonAOPStat extends CommonStat {
    public abstract Object around(ProceedingJoinPoint pjp) throws Throwable;
    public abstract void before();
    public abstract void after();
    public abstract void afterReturn(Object retVal);

}
