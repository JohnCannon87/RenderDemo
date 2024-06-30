package com.example.demo.logging;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AppContextEventListener {

	@EventListener
	public void handleContextRefreshed(ContextRefreshedEvent event) {
		printActiveProperties((ConfigurableEnvironment) event.getApplicationContext().getEnvironment());
	}

	private void printActiveProperties(ConfigurableEnvironment env) {

		System.out.println("************************* ACTIVE APP PROPERTIES ******************************");

		List<MapPropertySource> propertySources = new ArrayList<>();

		env.getPropertySources().forEach(it -> {
			if (it instanceof MapPropertySource && it.getName().contains("applicationConfig")) {
				propertySources.add((MapPropertySource) it);
			}
		});

		propertySources.stream()
				.map(propertySource -> propertySource.getSource().keySet())
				.flatMap(Collection::stream)
				.distinct()
				.sorted()
				.forEach(key -> {
					try {
						System.out.println(key + "=" + env.getProperty(key));
					} catch (Exception e) {
						log.warn("{} -> {}", key, e.getMessage());
					}
				});
		System.out.println("******************************************************************************");
	}
}