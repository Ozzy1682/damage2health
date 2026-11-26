cat > README.md <<'EOF'
# Damage2Health

**Damage2Health** is a Minecraft mod that increases your maximum health based on the damage you deal to mobs.

[![Modrinth](https://img.shields.io/modrinth/dt/damage2health?logo=modrinth&label=Modrinth)](https://modrinth.com/mod/damage2health)
[![CurseForge](https://img.shields.io/curseforge/dt/1590712?logo=curseforge&label=CurseForge)](https://www.curseforge.com/minecraft/mc-mods/damage2health)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

## Features

- **Damage to Health:** Dealing damage to mobs increases your maximum health by the amount of damage dealt.
- **No PvP Progress:** Damage dealt to other players does not increase your maximum health.
- **Persistent Progress:** Your accumulated damage is saved with your player data and restored when you rejoin your world.
- **AttributeFix Support:** Supports AttributeFix for exceeding Minecraft's normal maximum-health attribute limit.

## Downloads

Damage2Health is available on:

- [Modrinth](https://modrinth.com/mod/damage2health)
- [CurseForge](https://www.curseforge.com/minecraft/mc-mods/damage2health)

Download the compiled **Mod JAR** matching your Minecraft version and mod loader.

**Do not download the source code if you only want to install the mod.** Source code is intended for developers who want to inspect, modify, or build the project.

## Installation

1. Download the appropriate Damage2Health Mod JAR.
2. Install the required Minecraft mod loader.
3. Install all required dependencies listed on the download page.
4. Place the Damage2Health JAR in your Minecraft `mods` folder.
5. Launch Minecraft using the correct mod-loader profile.

## Dependencies

Required dependencies depend on the Minecraft version and mod loader.

Check the individual release's download page for its dependency requirements.

### AttributeFix

AttributeFix is optional.

Without AttributeFix, Minecraft's normal maximum-health attribute limit applies. Installing AttributeFix allows Damage2Health to increase maximum health beyond that limit.

[AttributeFix on Modrinth](https://modrinth.com/mod/attributefix)

## Supported Versions and Mod Loaders

Support varies by release. Check the [Modrinth versions](https://modrinth.com/mod/damage2health/versions) or [CurseForge files](https://www.curseforge.com/minecraft/mc-mods/damage2health/files) pages for currently available versions.

Do not assume that a build for one mod loader works with another.

## Development

Damage2Health is an open-source Minecraft mod.

The source code is available in this repository. Developers can clone the repository, inspect the implementation, make modifications, and build the project.

For Fabric development setup instructions, see the [Fabric documentation](https://docs.fabricmc.net/develop/getting-started/creating-a-project).

## License

Damage2Health is licensed under the [MIT License](LICENSE).
EOF
