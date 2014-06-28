#!/bin/bash

export PATH=$PATH:/home/group14/activator-1.2.2
activator start -J-Xms128M -J-Xmx256M -J-server -Dhttp.port=8080
