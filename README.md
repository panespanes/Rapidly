# Rapidly

logging the time a method invoke took to execute.

输出执行某一方法的耗时!<br>
只需加上注解@Rapdly<br>
```java
@Rapidly
public String howMuchTimeDidICost() {
  for (int i=0; i<20; i++){
    SystemClock.sleep(1);
  }
  return "it realy take a period. ";
}
```
