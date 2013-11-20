#!/bin/bash

git add bin/*
git add pom.xml
git add README.md
git add src/*
git add a
git add b
git add .gitignore

git commit -m "$1"
git push -u origin $2
