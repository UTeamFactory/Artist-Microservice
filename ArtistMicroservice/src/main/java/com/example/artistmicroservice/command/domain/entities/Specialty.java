package com.example.artistmicroservice.command.domain.entities;

import com.example.artistmicroservice.command.domain.values.*;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import javax.persistence.*;

@Aggregate
public class Specialty {

    @AggregateIdentifier
    private String id;

    private String specialtyName;

}
