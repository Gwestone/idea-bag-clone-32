package com.example.ideabagclone3.data

import com.example.ideabagclone3.data.models.DifficultLevels
import com.example.ideabagclone3.data.models.ReadItem
import com.example.ideabagclone3.data.models.SectionItem
import com.example.ideabagclone3.data.repo.ReadItemRepo
import com.example.ideabagclone3.data.repo.Repository
import com.example.ideabagclone3.data.repo.SectionItemRepo

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
class FakeDataSource {
    companion object{

        fun createFakeSectionDataList(): List<SectionItem>{
            var data: MutableList<SectionItem> = mutableListOf()
            for (i in 1..100){
                var temp = SectionItem(i, "sample section item data name", (10 * (i % 10)) % i )
                temp.contentItems = createFakeReadDataList()
                data.add( temp )
            }
            return data
        }

        fun createFakeReadDataList(): List<ReadItem>{
            var data: MutableList<ReadItem> = mutableListOf()
            for (i in 1..10){
                data.add( ReadItem(i, "sample section item data name", "Lorem ipsu sir dolom ammet", DifficultLevels.Baggier))
            }
            return data
        }

    }
}