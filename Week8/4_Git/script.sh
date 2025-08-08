#!/bin/bash
# Week 8 - Git Hands-on Exercise 4 Script
# This script demonstrates conflict resolution during a Git merge.

# Ensure master branch is clean
git checkout master
git status

# Create a new branch 'GitWork'
git checkout -b GitWork

# Add a file hello.xml in GitWork branch
echo "<message>Hello from GitWork branch</message>" > hello.xml
git add hello.xml
git commit -m "Add hello.xml in GitWork branch"

# Update hello.xml in GitWork branch
echo "<message>Hello from GitWork branch - updated</message>" > hello.xml
git status
git commit -am "Update hello.xml in GitWork branch"

# Switch back to master
git checkout master

# Add hello.xml with different content in master branch
echo "<message>Hello from master branch</message>" > hello.xml
git add hello.xml
git commit -m "Add hello.xml in master branch"

# View commit history
git log --oneline --graph --decorate --all

# Check differences between master and GitWork
git diff master GitWork

# Merge GitWork into master (will cause conflict)
git merge GitWork

# Conflict resolution will be done manually using a 3-way merge tool (e.g., P4Merge)

# After resolving conflict manually, mark file as resolved
git add hello.xml

# Commit the merge resolution
git commit -m "Resolve merge conflict between master and GitWork"

# Add backup file pattern to .gitignore
echo "*.orig" >> .gitignore
git add .gitignore
git commit -m "Add backup file pattern to .gitignore"

# List all branches
git branch -a

# Delete GitWork branch
git branch -d GitWork

# View final commit history
git log --oneline --graph --decorate
