package com.panes.rapidly.aspect;

import android.util.Log;

import com.panes.rapidly.log.RapidlyLog;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by panes on 2016/8/8.
 */
@Aspect
public class RapidlyAspect {
    public static final String TAG = "Rapidly";
    private static final String POINTCUT_METHOD =
            "execution(@com.panes.rapidly.annotation.Rapidly * *(..))";

    private static final String POINTCUT_CONSTRUCTOR =
            "execution(@com.panes.rapidly.annotation.Rapidly *.new(..))";

    @Pointcut(POINTCUT_METHOD)
    public void methodAnnotatedWithDebugTrace() {
    }

    @Pointcut(POINTCUT_CONSTRUCTOR)
    public void constructorAnnotatedDebugTrace() {
    }

    @Around("methodAnnotatedWithDebugTrace() || constructorAnnotatedDebugTrace()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        Log.d(TAG, "start time = " + System.nanoTime());
        RapidlyLog.log("start time = " + System.nanoTime());
        Object result = joinPoint.proceed();
        Log.d(TAG, "end time = " + System.nanoTime());
        RapidlyLog.log("end time = " + System.nanoTime());
        return result;
    }
}
