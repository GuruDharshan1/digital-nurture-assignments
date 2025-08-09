#!/bin/bash

# Verify main is in clean state
git checkout main
git status

# List all branches
git branch -a


git pull origin main


git push origin main


