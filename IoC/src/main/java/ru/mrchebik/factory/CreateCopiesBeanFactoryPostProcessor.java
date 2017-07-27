package ru.mrchebik.factory;

/**
 * Created by mrchebik on 18.02.17.
 */
/* @Component
public class CreateCopiesBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition initial = beanFactory.getBeanDefinition("initial");
        initial.getPropertyValues().add("count", 77);

        String[] qualifiers = beanFactory.getBeanNamesForType(Count.class);
        for (String qualifier : qualifiers) {
            if (!qualifier.equals("initial")) {
                ((DefaultListableBeanFactory) beanFactory).registerBeanDefinition(qualifier, initial);
            }
        }
    }
} */