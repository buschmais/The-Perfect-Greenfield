[![Gitpod ready-to-code](https://img.shields.io/badge/Gitpod-ready--to--code-908a85?logo=gitpod)](https://gitpod.io/#https://github.com/buschmais/The-Perfect-Greenfield)
[![Documentation Read Now](https://img.shields.io/badge/Documentation-Read%20Now-blue?logo=asciidoctor)](https://htmlpreview.github.io/?https://github.com/buschmais/The-Perfect-Greenfield/blob/main/documentation.html)

# The-Perfect-Greenfield

## About this repository

This repository showcases the initial steps needed to set up the perfect greenfield project, i.e. a system that is:

* architecturally well-thought-out, based on the real requirements
* clearly documented, i.e. documentation is easy to consume and produce and provides all necessary information to architects and developers
* explicit in the implementation of architectural concepts
* automatically validated in the conformance of implementation to documentation

With that, it tackles the most common issues of hard-to-maintain, if not even non-existing, documentation as well as having documentation and implementation aligned.

## So how do I implement the Perfect Greenfield?

The repository follows a reality-proven approach with 4 steps, each consisting of different methods and tools. 

1. Designing the Functional Architecture
    * Understand the functional requirements and use cases
    * Design use cases and a functional decomposition of the problem domain
    * Approaches: [Domain Storytelling][1], [Context Mapping][2] (additionally, you may want to consider Event Storming)
    * Tools: [Domain Story Modeler][3], [ContextMapper][4]
2. Designing the Technical Architecture
    * Understand the technical requirements by identifying quality qoals
    * Design the technical view on different abstraction levels and identify main concepts of the architecture 
    * Approaches: Definition and priorization of Quality Goals using [ISO 25010][5], Design of technical architecture
    * Tools: [C4-Model][6] for [PlantUML][7]
3. Communicating the Designed Architecture
    * Document the functional and technical architecture as well as the reasons that led to them using the prviously designed artifacts
    * Define implementation guidelines for developers to have a consistent and architecture-explicit code base
    * Approaches: [Arc42][8], [Architecture Decision Records][9], Architecture-explicit Code
    * Tools: Any AsciiDoc Editor, [jMolecules][10] with ByteBuddy [Integration][11]
4. Validating the Implementation of the Architecture
    * Make the documentation validate the implementation in an automated fashion
    * Generate documentation based on the actual implementation, e.g. runtime views and overviews of architecture violations
    * Approaches: [Living Documentation][12]
    * Tools: [jQAssistant][13] with integration for [jMolecules][14], [ContextMapper][15], and [Spring][16]  

## Using this repository

This repository was created so that each single step in designing and implementing the perfect greenfield can be followed using the commit history.

```console
$ git log --pretty=oneline --abbrev-commit
91b1433 (HEAD -> main, origin/main, origin/HEAD) Added Plantuml Reporting for Event Flow
3937eb2 Implementation of the Update Training Time use case
3f56db1 Implemented ADR for Bounded Context implementation
f9c919b Added ADR for Bounded Context implementation
2d3025b Implemented ADR for Usage of jQAssistant
62abbad Added ADR for Usage of jQAssistant
cb35c4e Implemented ADR for Usage of jMolecules
59c96d1 Added ADR for Usage of jMolecules
0a72884 Basic Maven Project Setup
210393f Added ADR overview and template
d2141d6 Updated Arc42 with available information
d70df01 Added Arc42 template
7a864db Added C4 Model Diagrams
38668e2 Added High-level Context Map
b3f179c Added Domain Stories
0e584f4 Added gitpod configuration
25bb45c Initial commit
```
You can use the project either using GitPod.io (see Badge in the beginning of this readme) or locally after cloning this repository.

Afterwards, simply run a ```mvn clean install``` (JDK 11 required).

Under ```target\jqassistant\report\asciidoc\``` you'll have the resulting documentation. This is also linked in the beginning of this readme.


[1]: https://domainstorytelling.org/
[2]: https://github.com/ddd-crew/context-mapping
[3]: https://www.wps.de/modeler/
[4]: https://contextmapper.org/
[5]: https://iso25000.com/index.php/en/iso-25000-standards/iso-25010
[6]: https://c4model.com/
[7]: https://github.com/plantuml-stdlib/C4-PlantUML
[8]: https://www.arc42.de/
[9]: https://www.cognitect.com/blog/2011/11/15/documenting-architecture-decisions
[10]: https://github.com/xmolecules/jmolecules
[11]: https://github.com/xmolecules/jmolecules-integrations/tree/main/jmolecules-bytebuddy
[12]: https://www.oreilly.com/library/view/living-documentation-continuous/9780134689418/
[13]: https://jqassistant.org/
[14]: https://github.com/jqassistant-contrib/jqassistant-jmolecules-plugin
[15]: https://github.com/jqassistant-contrib/jqassistant-context-mapper-plugin
[16]: https://github.com/jQAssistant/jqa-spring-plugin
