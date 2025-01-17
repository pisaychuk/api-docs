#!/bin/sh

mkdir publish-specs
cd publish-specs

git init
git remote add origin https://$DX_GIT_USER:$DX_GIT_TOKEN@github.com/Bandwidth/openapi-specs.git
git pull origin main
git checkout main

cp -R ../$SPECS_DIRECTORY/* .
git add .
git config user.name $DX_GIT_USER
git config user.email $DX_GIT_EMAIL
git diff --quiet && git diff --staged --quiet || git commit -m "Specs update"
#taken from https://stackoverflow.com/questions/22040113/how-to-let-jenkins-git-commit-only-if-there-are-changes
#git commit will fail the build if there are no file changes
git push origin main
#git push will not fail the build if there is nothing to push
cd ..
