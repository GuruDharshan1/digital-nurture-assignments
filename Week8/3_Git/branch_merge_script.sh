#!/bin/bash

# Branching
git checkout -b GitNewBranch
git branch -a
touch branchfile.txt
echo "This is a file in GitNewBranch" > branchfile.txt
git add branchfile.txt
git commit -m "Added branchfile.txt in GitNewBranch"
git status

# Merging
git checkout master
git diff GitNewBranch

git merge GitNewBranch
git log --oneline --graph --decorate

# Optional: delete the branch
git branch -d GitNewBranch
git status
