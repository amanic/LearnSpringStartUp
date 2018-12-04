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

封装beanDefinition的过程，
找到doLoadBeanDefinitions之后，就有了registerBeanDefinitions：

protected void doRegisterBeanDefinitions(Element root) {
		// Any nested <beans> elements will cause recursion in this method. In
		// order to propagate and preserve <beans> default-* attributes correctly,
		// keep track of the current (parent) delegate, which may be null. Create
		// the new (child) delegate with a reference to the parent for fallback purposes,
		// then ultimately reset this.delegate back to its original (parent) reference.
		// this behavior emulates a stack of delegates without actually necessitating one.
		BeanDefinitionParserDelegate parent = this.delegate;
		this.delegate = createDelegate(getReaderContext(), root, parent);
		if (this.delegate.isDefaultNamespace(root)) {
			String profileSpec = root.getAttribute(PROFILE_ATTRIBUTE);
			if (StringUtils.hasText(profileSpec)) {
				String[] specifiedProfiles = StringUtils.tokenizeToStringArray(
						profileSpec, BeanDefinitionParserDelegate.MULTI_VALUE_ATTRIBUTE_DELIMITERS);
				if (!getReaderContext().getEnvironment().acceptsProfiles(specifiedProfiles)) {
					if (logger.isInfoEnabled()) {
						logger.info("Skipped XML bean definition file due to specified profiles [" + profileSpec +
								"] not matching: " + getReaderContext().getResource());
					}
					return;
				}
			}
		}
		preProcessXml(root);
		parseBeanDefinitions(root, this.delegate);
		postProcessXml(root);
		this.delegate = parent;
	}
	
	其中最主要的是parseBeanDefinitions：
	/**
    	 * Parse the elements at the root level in the document:
    	 * "import", "alias", "bean".
    	 * @param root the DOM root element of the document
    	 */
    	protected void parseBeanDefinitions(Element root, BeanDefinitionParserDelegate delegate) {
    		if (delegate.isDefaultNamespace(root)) {
    			NodeList nl = root.getChildNodes();
    			for (int i = 0; i < nl.getLength(); i++) {
    				Node node = nl.item(i);
    				if (node instanceof Element) {
    					Element ele = (Element) node;
    					if (delegate.isDefaultNamespace(ele)) {
    						parseDefaultElement(ele, delegate);
    					}
    					else {
    						delegate.parseCustomElement(ele);
    					}
    				}
    			}
    		}
    		else {
    			delegate.parseCustomElement(root);
    		}
    	}
    	这个是这一期的主题：
    	parseCustomElement()用来处理自定义命名空间：
    	这里得到NamespaceHandler来parse，然后通过find来找到合适的handler实现类。然后处理，这里的实现类有很多：BeanDefinitionParser：
    	比如：ComponentScanBeanDefinitionParser，AspectJAutoProxyBeanDefinitionParser等。
    	
------------------------------------------------------------------------------------------------------------------------﻿

