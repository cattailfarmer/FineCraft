# Terasology Source Structure Guide for FineCraft

This document is a comprehensive guide to the Terasology source tree, now forked into FineCraft. It is our map for understanding the file structure, planning match points, and guided modifications.

The project folders include:

## Root /Top-Level Files & Directories

 - `.github/` - GitHub workflow and issue templates.
 - `.dea/` - IntellI) project metadata.
 - `build-logic/` : Gradle plugin logic for builds.
 - `config/` - Build and code style config.
 - `docs-pre-merge/` : Staging docs before merge.
 - `docs/` : User and developer docs.
 - `engine-tests/` : Unit and integration tests for engine.
 - `engine/` : Core engine code including physics, simulation, rendering, etc.
 - `facades/` : Facade layers (interfaces).
 - `fileTemplates/` : Templates for new classes.
 - `gradle/` : Gradle build wrapper.
 - `libs/` : External libraries.
 - `metas/` : Project metadata.
 - `modules/` : Gameplay content modules.
 - `openvr_natives/` : Native libs for VR.
 - `subsystems/` : Additional subsystems (audio, input,etc.)
 - `templates/` : Default asset/file templates.

## Engine Subdivisions

 engine/
  - core/
  - audio/
  - entitySystem/
  - logic/
  - physics/  *** <!-- INTEREST: Spot to make abstraction layer for Toribrot -->
  - rendering/
  - networking/
  - input/
  - ui/

Contains the bullet/JBullet based physics subsystems. These are our prime target for replacement by Toribrot accelerated physics.

## Facades

Contain frameworks to abstract the engine from modules and external consumers.


## Modules

Each module provides gameplay content on top of the engine. Modules may need adaptation to any changes in the physics api. Kiep for backcompatibility.


## Engine Tests

Testsuites for engine ensuring accuracy and regression. We will add new tests for physics abstraction and Toribrot performance.
