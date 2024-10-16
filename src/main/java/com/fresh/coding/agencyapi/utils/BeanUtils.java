package com.fresh.coding.agencyapi.utils;

import com.fresh.coding.agencyapi.exceptions.BeanMappingException;

public class BeanUtils {
    public static <S, T> T map(S source, Class<T> targetClass) {
        try {
            T target = targetClass.getDeclaredConstructor().newInstance();
            copyPropertiesIgnoring(source, target, new String[0]);
            return target;
        } catch (Exception e) {
            throw new BeanMappingException("Error mapping beans from " + source.getClass().getSimpleName() + " to " + targetClass.getSimpleName(), e);
        }
    }

    public static <S, T> void map(S source, T target) {
        if (source != null && target != null) {
            copyPropertiesIgnoring(source, target, new String[0]);
        } else {
            throw new IllegalArgumentException("Source and target must not be null");
        }
    }

    public static <S, T> void copyPropertiesIgnoring(S source, T target, String[] ignoreProperties) {
        if (source != null && target != null) {
            try {
                org.springframework.beans.BeanUtils.copyProperties(source, target, ignoreProperties);
            } catch (Exception e) {
                throw new BeanMappingException("Error copying properties from " + source.getClass().getSimpleName() + " to " + target.getClass().getSimpleName(), e);
            }
        } else {
            throw new IllegalArgumentException("Source and target must not be null");
        }
    }
}
