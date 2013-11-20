#!/bin/bash

git add .

git commit -m "$1"
git push -u $2 master
