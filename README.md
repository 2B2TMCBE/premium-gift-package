(中文版README)[https://github.com/2B2TMCBE/premium-gift-package/blob/main/readme-zh.md]

# Premium Gift Package
- This is a plugin that allows admin to copy their inventory as a gift packages and publish to five different permission groups, these permission groups can claim these packages with a command with the predefined permissions.
# Features
- Allow admin to copy their inventory with /packgift command
- Allow admin to define the expiration date and permission group for a certain package
- Allow admin to publish their gift package
- Allow players to claim the gift package
# Coding Style
- This plugin doesn't have a predefined coding style
# API/Framework Used
- Paper Spigot Engine
# Commands
- /gifts 
  - Allow Players to claim a gift
- /packgift <expiration in hours> <permission group(level1, level2, level3, level4, level5)>
  - Allow admin to create a giftpackage from their inventory data and define the expiration date, and permission group
# Installation
- This installation guide is for Debian linux only, windows please download the newest jar file from https://github.com/2B2TMCBE/2b2tpe/releases and then proceed to step 7.

1. require installation of Paper Spigot.
2. Download maven using this command:
```sudo apt-get install maven```
3. After installation, run this command to clone this git repository:
```git clone https://github.com/2B2TMCBE/premium-gift-package.git```
4. Change directory to the plugin's base directory, which contains the file named pom.xml
5. Run this command to compile the plugin using maven
```mvn clean package```
6. Wait until the compiling process is completed, a new directory named `target` should now be created, nevigate into target.
7. move the jar file named `premium_gift-1.0-SNAPSHOT-shaded.jar` into Paper's server directory, move it into a directory named plugins.
8. Restart the server, the plugin should be installed.
# Contribution
- This project is open to pull request and everyone can use, fork, make private, or modify this plugin
# License
MIT License
