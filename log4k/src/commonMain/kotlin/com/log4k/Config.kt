package com.log4k

data class Config(
  val enable: Boolean = true,
  val qualifiedName: String,
  val owners: Array<String> = arrayOf(),
) {

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other == null || this::class != other::class) return false

    other as Config

    if (enable != other.enable) return false
    if (qualifiedName != other.qualifiedName) return false
    if (!owners.contentEquals(other.owners)) return false

    return true
  }

  override fun hashCode(): Int {
    var result = enable.hashCode()
    result = 31 * result + qualifiedName.hashCode()
    result = 31 * result + owners.contentHashCode()
    return result
  }
}
