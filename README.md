# SpringbootReactRest
Springboot, Rest, Reactjs, Axios


Springboot framework, Rest, Reactjs, Axiom

For backended project use Springboot framework and for frontended react.js. Springboot dependencies: Spring Boot DevTools, Spring Data JPA, H2 Database, Spring Web. React.js is using axios librarie.
******
Backended

Interface: CountryRepository - extends Jpa reporitory and give access to GET, POST, UPDATE, DELETE methos without writting SQL querys. Annotation @Repository. CountryService - define methods wich need to be used in MainService. Annotation @Service.

Classes: Country - define our country object which need to be saved in repository. Also helps retrieve data from external source and generate json. Annotation @Entity @JsonIgnoreProperties. MainService - implements CountryService and override its methods. MainService sends query to CountryRepository.
Annotation @Service. MainController - handles client request. In this case request for country name and sends it to MainService.Annotation @RestController @CrossOrigin. RunDatabaseOnStart - retrieve data from external source and saves it in CountryRepository. Data is always retrieved and saved on start one time. Before saving external data is arranged according to the requirements what is needed for our app (Country name, year of the week, indicator, case number and death number). Annotation @Component. IbmInternshipApplication - main class, runs application. Annotation @SpringBootApplication.
******
Frontended

TableDropdown - create Dropdown button which item is country from given country list. Create table which get information by choosen country from dropdown.
