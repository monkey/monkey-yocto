# Monkey + Yocto Project

This repository contains the official recipes to build Monkey on [Yocto Project](https://www.yoctoproject.org/).

## Getting Started

The following instructions assumes that your are building [Yocto](https://www.yoctoproject.org/) images from scratch using the [Poky](https://www.yoctoproject.org/tools-resources/projects/poky) tool:

Get a copy of this repository in your local computer, then copy the __monkey__ directory into your __meta recipes-extended__ directory:

```Shell
$ cp -r monkey-yocto/monkey /home/foo/poky/meta/recipes-extended/
```

Once there, go into the __build/__ directory and make a test building Monkey:

```Shell
$ bitbake monkey
```
