package tech.lyuku.mvvm_template.base.core.db

import io.realm.Realm

interface IRealmProvider {

    suspend fun getRealm(): Realm
}
