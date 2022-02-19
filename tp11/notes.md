#Annotations
- @Service
- @Repository
- @Transaction
- @Inheritance

#Relations
- HAS A (Client HAS A List of Commands)
- IS A (ClientVIP/ClientNormal IS A Client)
- IS LIKE (Human IS Like ICarnivor, Human IS Like IHerbivor)

#@Inheritance
### SINGLE_TABLE
to not create another table for ClientVIP

    @Inheritance (strategy = InheritanceType.SINGLE_TABLE)

- adds the columns of both VIP and Normal to CLient table

col to differentiate between ClientVIP and ClientNormal

    @DescriminatorColumn(name ="type")
    @Inheritance (strategy = InheritanceType.SINGLE_TABLE)

to give the Descriminator value, daughter classes have to be @Entity with

    @Entity
    @DescriminatorValue("blabla")
    
###TABLE_PER_CLASS
    
    @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

- create tables for Client, VIP and Normal
- tables VIP and NORMAL have their own cols and Client's cols

###JOINED

    @PrimaryKeyJoinColumn
    @id
    long id
    
##Map Composite Primary key @EmbeddedId @IdClass
    
    class LigneFacture {
        long idProduct;
        long idFacture;
        double qte;
    }
    
- @IdClass
    
    
    @IdClass(PK.class)
    @Entity
    class LigneFacture implements Serializable{
        long idProduct;
        long idFacture;
        double qte;
    }
    
    
    class PK {
        long idProduct;
        long idFacture;
        double qte;
        //override hashCode and equals
    }
    
    
- @EmbeddedId
    
    
    
    @Entity
    class LigneFacture implements Serializable{
        @EmbeddedId
        PK p;
    }
    
    
    class PK implents Serializable{
        long idProduct;
        long idFacture;
        double qte;
        //override hashCode and equals
    }
    
##@Embedded @Embeddable
    
    @Entity
    class Entreprise {
        long id
        string phone
        @Embedded
        Contact c
    }
    
    @Embeddable
    class Contact {
        @AttributeOverride
        string phone
    }
   
##implements Serializable
- to be able to stream an object's bytes

## hashCode & equals
- override hashCode and equals to guarantee equality between object with same Identifier and class


#Injection with @AutoWired and @Component
- @Component is instantiated at startup


    @Component
    class MyController
        @AutoWired
        MyService service;
    ...
    
    @Component
    class MyService
    ...
    
- it's better to use Component aliases for clarity
    
    
    @Service
    class MyService
    ...
    @Controller
    class MyController
    ...
    @Repository
    class MyRepo
    ...

- injecting entity manager
    
    
    @PersistenceContext
    EntityManager em;
## initializing components, component-scan




#@Transactional

    @Transactional
    void save(Client c){
        repo.save()
        //all the operations here are transaction and get rolled back in case of Exceptions
    }
     
