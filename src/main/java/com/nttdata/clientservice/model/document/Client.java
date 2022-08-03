package com.nttdata.clientservice.model.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase Client.
 */

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "clients")
public class Client {

  @Id
  private String id;

  private String documentType;
  private String documentNumber;
  private String name;
  private String clientTypeId;

}
