package app.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "_id", "codigo", "desEmpleo", "desPuesto", "tipo", "pais", "provincia", "municipio", "mod",
		"fecMod", "fecPub", "disc", "url" })

@Data
@NoArgsConstructor
@Document(collection = "jobs")
public class Job {

	@JsonProperty("_id")
	private String id;
	@JsonProperty("codigo")
	private String codigo;
	@JsonProperty("desEmpleo")
	private String desEmpleo;
	@JsonProperty("desPuesto")
	private String desPuesto;
	@JsonProperty("tipo")
	private String tipo;
	@JsonProperty("pais")
	private String pais;
	@JsonProperty("provincia")
	private String provincia;
	@JsonProperty("municipio")
	private String municipio;
	@JsonProperty("mod")
	private String mod;
	@JsonProperty("fecMod")
	private String fecMod;
	@JsonProperty("fecPub")
	private String fecPub;
	@JsonProperty("disc")
	private String disc;
	@JsonProperty("url")
	private String url;

}