/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gemantic.common.stat.aop.time;

import com.gemantic.common.stat.aop.CommonAOPStat;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 
 * @author hongzhong
 */
public class AroundTimeConsume extends CommonAOPStat {
	private static long LOG_THREASHOLD_TIME = 50; // ms

	@Override
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		long t1 = System.currentTimeMillis();

		Object ret;

		ret = pjp.proceed();
		long time = System.currentTimeMillis() - t1;

		logger.info(printInfo(pjp, time, null, 0, false));

		return ret;

	}

	private String printInfo(ProceedingJoinPoint pjp, long time,
			StringBuilder sb, int size, boolean isDetail) {
		StringBuffer sbuffer = new StringBuffer();
		sbuffer = sbuffer.append(pjp.getTarget().getClass());
		sbuffer = sbuffer.append(".").append(pjp.getSignature().getName());
		sbuffer = sbuffer.append("(");
		sbuffer = sbuffer.append(pjp.getSignature().getDeclaringTypeName());
		sbuffer = sbuffer.append(") ");
		sbuffer = sbuffer.append("pjp.toShortString()");
		sbuffer = sbuffer.append(" process time: ");
		sbuffer = sbuffer.append(time);
		sbuffer = sbuffer.append(" size: ");
		sbuffer = sbuffer.append(size);
		if (isDetail) {
			sbuffer = sbuffer.append(" params: ");
			sbuffer = sbuffer.append(sb.toString());
		}

		return sbuffer.toString();
	}

	private StringBuilder convert2ParamStrings(ProceedingJoinPoint pjp) {
		StringBuilder sb = new StringBuilder();
		Object[] args = pjp.getArgs();
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				sb.append(" p").append(i).append("=").append(args[i]);
			}
		}
		return sb;
	}

	@Override
	public void before() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void after() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void afterReturn(Object retVal) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
