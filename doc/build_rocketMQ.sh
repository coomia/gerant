#!/usr/bin/env bash

cd $ROCKETMQ_HOME"/bin"

nohup sh mqnamesrv > $ROCKETMQ_HOME"/nameserviceLog/" 2>&1 &
nohup sh mqbroker -n localhost:9876 > $ROCKETMQ_HOME"/nameserviceLog/" 2>&1 &