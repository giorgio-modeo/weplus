/*
  Warnings:

  - You are about to drop the column `url` on the `bookmarks` table. All the data in the column will be lost.

*/
-- AlterTable
ALTER TABLE `bookmarks` DROP COLUMN `url`,
    ADD COLUMN `link` VARCHAR(191) NULL;
