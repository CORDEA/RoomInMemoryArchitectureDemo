package jp.cordea.roominmemoryarchitecturedemo

import dagger.Module

@Module(
    includes = [
        MainActivityModule::class
    ]
)
interface ActivityModule
