package br.com.unipac.protocoloapi.model.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_protocolos")
public class Protocolo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name = "full_name") //fullName
    private String nome;
    private String email;
    @Column(name = "documento_id")
    private Integer documentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    @Override
    public String toString() {
        return "Moderador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", documentId=" + documentId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Protocolo protocolo = (Protocolo) o;
        return Objects.equals(id, protocolo.id) && Objects.equals(nome, protocolo.nome) && Objects.equals(email, protocolo.email) && Objects.equals(documentId, protocolo.documentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, documentId);
    }
}