------------------------------------------------------------------------------------------------------------------------﻿
/**
 * Apply before-instantiation post-processors, resolving whether there is a
 * before-instantiation shortcut for the specified bean.
 * @param beanName the name of the bean
 * @param mbd the bean definition for the bean
 * @return the shortcut-determined bean instance, or {@code null} if none
 */
protected Object resolveBeforeInstantiation(String beanName, RootBeanDefinition mbd) {
   Object bean = null;
   if (!Boolean.FALSE.equals(mbd.beforeInstantiationResolved)) {
      // Make sure bean class is actually resolved at this point.
     // 如果存在InstantiationAwareBeanPostProcessor对象⬇️
      if (!mbd.isSynthetic() && hasInstantiationAwareBeanPostProcessors()) {
         Class<?> targetType = determineTargetType(beanName, mbd);
         if (targetType != null) {
// 调用的是postProcessBeforeInstantiation方法⬇️
            bean = applyBeanPostProcessorsBeforeInstantiation(targetType, beanName);
            if (bean != null) {
                 // 如果返回的数据不为null，则调用的是postProcessAfterInitialization方法⬇️
                 // 注意别看错了，一个是实例化Instantiation，一个是初始化Initialization⬇️
               bean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
            }
         }
      }
        // 记录下是否通过提前批次的处理（如果bean不为null，则肯定是）⬇️
      mbd.beforeInstantiationResolved = (bean != null);
   }
   return bean;
}
上面这个方法，实在createBean（并不是doCreateBean）方法的时候，检查是否有自定义生成的bean如上第17行，
﻿InstantiationAwareBeanPostProcessor 接口里﻿postProcessBeforeInstantiation会有机会自定义生成bean，
这里即使实现了BeanPostProcessor，这个接口后面的方法也不会执行了，并且！
即使接口实现了BeanPostProcessor接口，也不会去执行该接口的﻿postProcessBeforeInitialization方法，只会执行
﻿postProcessAfterInitialization方法。
------------------------------------------------------------------------------------------------------------------------﻿
