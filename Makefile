
deps:
	rm -fr node_modules
	yarn
	patch node_modules/metro/src/JSTransformer/worker.js ./worker.patch

release-android:
	if [ ! -f android/app/aluminium-release-key.keystore ] ; then exit 1; fi;
	lein do clean, with-profile advanced cljsbuild once android
	cd android && ./gradlew assembleRelease
