package ejercicioGestionDeCandidaturas.modelPojo;

import jakarta.persistence.*;

import java.util.List;

@Entity  //define que es una entidad dentro de una database.
@Table(name = "users")  //para poner el nombre de la Tabla. Para que no se ponga como el nombre de la clase, se lo especificamos nosotros.
//uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "mail"})})  //para que no se puedan introducir dos valores con estos dos mismos atributos iguales.
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //para que se auto incremente solo.
    @Column(name = "id")  //para que la columna de la tabla se llame como le digas.
    private long id;

    @Column(name = "name")  //para que la columna de la tabla se llame como le digas.
//    @Column(nullable = false)  //para que este atributo no puede ser nulo y se tenga que insertar obligatoriamente.
    private String name;

    @Column(name = "mail")
    private String mail;

    @Column(name = "description")
    private String description;

    @Column(name = "telephone")
    private int telephone;

    @ManyToMany(  //muchos a muchos.
            mappedBy = "users"  //En el mappedBy ponemos el nombre de la tabla de esta clase.
            //fetch = FetchType.LAZY
            //El FetchType.EAGER: cuando se hace un select te trae ttodo lo que tiene que ver con esta clase. Te va a traer todas las asignaturas que tiene el profesor. Cuando te da un ERROR de que hay muchas llmadas se pone LAZY y se arregla.
            //El FetchType.LAZY: por defecto si no pones nada es este. Cuando se hace un select te trae ttodo lo que tiene que ver con esta clase menos las asignaturas y así controlas lo que te devuelve. Hay que crear un método para saber cuales asignatruas son las que están relacionadas con cada profesor.
    )
    private List<Skill> skills;

    @OneToMany(  //uno a muchos.
            mappedBy = "user",  //mapeamos el valor de la variable de la otra clase que hace la relación con esta clase.
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}  //al ser "CascadeType.PERSIST / MERGE" cada vez que se cree y actualice un "author", se hace en cascada y se modifica la referencia primero esta clase y luego en la que está referenciada.
    )
    private List<Candidature> candidatures;

    @OneToMany(  //uno a muchos.
            mappedBy = "user",  //mapeamos el valor de la variable de la otra clase que hace la relación con esta clase.
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}  //al ser "CascadeType.PERSIST / MERGE" cada vez que se cree y actualice un "author", se hace en cascada y se modifica la referencia primero esta clase y luego en la que está referenciada.
    )
    private List<LaboralExperience> laboralExperiences;

    @OneToMany(  //uno a muchos.
            mappedBy = "user",  //mapeamos el valor de la variable de la otra clase que hace la relación con esta clase.
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}  //al ser "CascadeType.PERSIST / MERGE" cada vez que se cree y actualice un "author", se hace en cascada y se modifica la referencia primero esta clase y luego en la que está referenciada.
    )
    private List<Candidature> academicInfos;


    //constructor
    public User() {
    }


    //toString
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", description='" + description + '\'' +
                ", telephone=" + telephone +
                ", skills=" + skills +
                ", candidatures=" + candidatures +
                ", laboralExperiences=" + laboralExperiences +
                ", academicInfos=" + academicInfos +
                '}';
    }


    //getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Candidature> getCandidatures() {
        return candidatures;
    }

    public void setCandidatures(List<Candidature> candidatures) {
        this.candidatures = candidatures;
    }

    public List<LaboralExperience> getLaboralExperiences() {
        return laboralExperiences;
    }

    public void setLaboralExperiences(List<LaboralExperience> laboralExperiences) {
        this.laboralExperiences = laboralExperiences;
    }

    public List<Candidature> getAcademicInfos() {
        return academicInfos;
    }

    public void setAcademicInfos(List<Candidature> academicInfos) {
        this.academicInfos = academicInfos;
    }
}