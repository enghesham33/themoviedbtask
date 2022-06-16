package io.ramani.themoviedbtask.domainCore;

import java.util.List;

public interface ModelMapper<From, To> {
    To mapFrom(From paramFrom);

    List<To> mapFrom(List<From> paramList);

    From mapTo(To paramTo);

    List<From> mapTo(List<To> paramList);
}
