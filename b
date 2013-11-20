#!/bin/bash

git add .

git commit -m "Arnar: $1"
git push -u $2 master
