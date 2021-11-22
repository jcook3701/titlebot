#!/usr/bin/make

.PHONY: build clean

defualt: build
.ONESHELL:

build:
	@mkdir bin
	@cd bin
	@scalac ../src/TitleBotCrawler.scala

clean:
	@rm -r bin
