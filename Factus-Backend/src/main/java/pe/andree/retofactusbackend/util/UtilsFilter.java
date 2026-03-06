package pe.andree.retofactusbackend.util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

public class UtilsFilter    {

    private UtilsFilter(){};

    public static <T> Specification<T> stringLike(
            String field,
            String value
    ) {
        return (root, query, cb) -> {
            if (value == null || value.isBlank()) return null;
            return cb.like(
                    cb.lower(root.get(field)),
                    "%" + value.toLowerCase() + "%"
            );
        };
    }

}
