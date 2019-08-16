#!/usr/bin/env bash

cd $ROCKETMQ_HOME"/bin"

nohup sh mqnamesrv > ${rocketHome}"/bin/nameserviceLog/" 2>&1 &
nohup sh mqbroker -n localhost:9876 > ${rocketHome}"/bin/nameserviceLog/" 2>&1 &