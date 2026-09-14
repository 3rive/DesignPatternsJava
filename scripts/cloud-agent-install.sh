#!/usr/bin/env bash
set -euo pipefail

cd /workspace

if [[ -f pom.xml ]]; then
  mvn -B -q dependency:resolve
fi
